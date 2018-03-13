# Initialization of a multiagent system

[:Outline:]

This document describes the key elements and the best practices for initializing and starting up a multiagent system.
Before reading this document, it is recommended reading
the [General Syntax Reference](../reference/GeneralSyntax.md).

Initialization of a multiagent system is a hard problem, and specifically with SARL in which the
[agent spawning is run in parallel](./ParallelExecution.md).

The problem is: how ensuring that all the agents on the system are alive before starting to run their
standard behaviors?

## Example of a problematic system

First, let consider a SARL code that is not working.
In the following code, the type of agent [:myagentname:] is defined.
This type of agent emits an [:myeventname:] event when the application starts, i.e. when the agent is initialized.
Assuming that 100 agents will be launched, it is expected to see 100*100 messages [:msg1:] within the log.

		[:Success:]
			package io.sarl.docs.tutorials.masinitialization
			import io.sarl.core.DefaultContextInteractions
			import io.sarl.core.Logging
			import io.sarl.core.Initialize
			[:On]
			event [:myeventname](MyEvent)

			agent [:myagentname](MyAgent) {
				uses DefaultContextInteractions, Logging
				[:initializeblock](on Initialize) {
					[:emit](emit)(new MyEvent)
				}

				[:myeventblock](on MyEvent) {
					info([:msg1]("Event received"))
				}
			}
		[:End:]

For starting the system, we could define a booting agent like:
		[:Success:]
			package io.sarl.docs.tutorials.masinitialization
			import io.sarl.core.Initialize
			import io.sarl.core.Lifecycle
			event MyEvent
			agent MyAgent {
			}
			[:On]agent BootAgent {
				uses Lifecycle
				on Initialize {
					for (i : 1..100) {
						[:spawnfct](spawn)(typeof(MyAgent))
					}
					killMe
				}
			}
		[:End:]
		
According to the expected [agent spawning's parallel execution](./ParallelExecution.md), the calls to the
[:spawnfct:] function form a sequence of 100 calls.
And, each call to the [:spawnfct:] function starts a spawning task that is run within a separated thread.

From this parallel execution behavior, there is no warranty about:
* the order of the agent initialization is the same as the order of the [:spawnfct:] calls;
* when the spawning loop is finished, all agents are spawned.
* the number of logged messages is 100*100.

Consequently, the general behavior of the system is not deterministic.
We cannot infer the number of messages that will be logged because some event may be fired by events before several
other agents are still waiting for their spawns.

## Solution: waiting for the agent spawning

On solution to the previously mentionned problem is to split the starting up of the application into two steps:
1. Spawning of the agents: agents are spawn, and the system waits until all the agents are alive and ready.
2. Application start: an specific event is given to all the agents for notifying them that they could start their "standard" behavior.

Consequently, the agent's code may be redefined as follow:
		[:Success:]
			package io.sarl.docs.tutorials.masinitialization
			import io.sarl.core.DefaultContextInteractions
			import io.sarl.core.Logging
			event MyEvent
			[:On]
			event [:startappevent](StartApplication)

			agent MyAgent {
				uses DefaultContextInteractions, Logging
				[:initializeblock](on StartApplication) {
					[:emit](emit)(new MyEvent)
				}

				[:myeventblock](on MyEvent) {
					info([:msg2]("Event received"))
				}
			}
		[:End:]
		
The agent emits the [:myeventname:] event only when the application has started.
This application-start event is represented by the [:startappevent:] event.

The booting agent becomes:
		[:Success:]
			package io.sarl.docs.tutorials.masinitialization
			import io.sarl.core.Initialize
			import io.sarl.core.Lifecycle
			import io.sarl.core.AgentSpawned
			import io.sarl.core.DefaultContextInteractions
			event StartApplication
			agent MyAgent {
			}
			[:On]agent BootAgent {
				uses Lifecycle, DefaultContextInteractions
				
				var count = 0
				
				on Initialize {
					for (i : 1..100) {
						spawn(typeof(MyAgent))
					}
				}
				
				on [:agentspawnedevent](AgentSpawned) {
					count++
					if (count == 100) {
						emit(new StartApplication) [it.UUID != UUID]
						killMe
					}
				}
			}
		[:End:]

The two major steps of the multiagent system initialization are implemented.
First, when the boot agent starts its life, it is spawning all the agents.
Each time an agent is spawned, the booting agent is notified with an [:agentspawnedevent:] event.
When the number of spawned agents reaches 100, the booting agent notifies about the application start
and commits a suicide.

[:Include:](../legal.inc)
