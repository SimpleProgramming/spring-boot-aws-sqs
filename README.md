# Spring Boot AWS SQS

SQS is a distributed queuing system, which gives access to a message queue that you can use to store 
messages while waiting for the end system to process it

There are two types of SQS queues

    Standard and FIFO queues

Standard queues guarantees message delivery at least once.
But if there is a high volume of transactions in a distributed system, messages get delivered more than 
one time, which might cause confusion in the system

In order to avoid this issue, you can opt for FIFO queues
As the name suggests the messages will be delivered First in first out manner
It delivers the message only once
messages are made available only till the consumer processes it, once the consumer processes the message, 
it is deleted this queue mechanism eradicates the duplicate transactions
