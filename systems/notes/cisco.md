#####SOTD: Paranoid Android - Radiohead
#Aim: Cisco in an hour

###Do Now: What needs to happen in order for 2 computers to communicate with each other?

###OSI 7-Layer Model

Used to help conceptualize the different parks of network connections.

The top layer is the most concrete, with each subsequent layer becoming more abstract (relying less on the physical connections and more on code).

####The Layers:
 1. Physical
 2. Data Link
 3. Network
 4. Transport
 5. Session
 6. Presentation
 7. Application
 
If you are working on a particular layer, you should not have to think too much about the other layers.

#####Physical Layer

How computesr are physically connected

Things like electrons running across wires, radio signals pulsing through the air...

A brief history of wired connections

- _Thicknet_
 - "vampire junction"
- _Thinnet_
 - A single Coaxial cable runs throughout the network, T-Junctions used to splice connections
 
 In Thicknet and Thinnet, all data is sent to all computers.
 
 Each computer added increases the power drain on the entire system, degrading service

_Token Ring_
Each computer is connected in a ring with each other

Only one computer has command of the network resources at a tie. This is called "having the token".

The network sends a "token" throughout the ring, which contains the identity of the computer with the token. All other computers must wait to use the network.

No possibility of collisions.

_Ethernet_

Multiple computers connect to a single hub or switch

- *Hub*
 - Broadcasts the daya to all the computers
- *Switch*
 - Sends data to a specific computer (Needs to look at Data Link Layer)
 
 The more computers you add to an eternet network the greater the chance of collisions
 
#Aim: Cisco in an hour III: in 3-D!

Data Link Layer (2)
