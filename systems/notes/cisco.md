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

Point-to-point transmission between devices on the same (local) network

Each device is given a unique 6-byte MAC (Media Access Control) address, this is set on each network card when they are made.

Data is packaged into frames

- _Ethernet Frames:_
`<prefix><dest><source><...>< data ><checksum>`
`    8B    6B    6B      6B   46-1500B   4B `

 - prefix: 10101010 x7 + 10101011
 - destination/source: MAC addresses 
 - ...: Information about frame type
 - checksum: to ensure data integrity
 
 _MTU_
 Maximum Transmission Unit
 1500 Bytes for ethernet

#Aim: Cisco in an hour IV: A New Hope

###Network Layer (3)
Transmission of data between two separate networks

Major features of this layer are addressing, routing, and packet forwarding.

Is not concerned with whether or not data was sent successfully (connectionless).

- IP (internet protocol) addresses
 - IPv4: 4 byte address
  - [0-255] . [0-255] . [0-255] . [0-255]
  
#Aim: Cisco in an hour: V for Vendetta

###Network Layer 
* IP (Internet Protocol) addresses
- IPv4: 4 byte address
 - [0-255] . [0-255] .  [0-255] . [0-255]
 - Routing is made easier by having IP addresses distributed to in blocks
 
#Aim: Cisco in an hour VI: The Undiscovered Country

###Network Layer (3)

Data is broken into packets

| Packets | of | Code | Size |
|:-------:|:--:|:----:|:----:|
| `<header info>` |  `<packet length>` | `<fragment info>` | |
|     2B   |           2B |            4B| | 
| `<time-to-live>` | `<protocol>` | `<header checksum>`| |
|     1B            |  1B            | 2B| |
| `<source>` |`<destination>`|` <...>      <data>`| |
|     4B            |  4B  | 4B     |     20 - 65,535B| 

*header info*: packet type (IPv4/6), header length...

*fragment info*: Full payloads may be broken up, this will have total # of fragments as well as which fragment the current packet contains

*time to live*: Maximum # of hops before the packet dies

*protocol*: TCP/UDP/...

...:optional information depending on type of packet

IP MTU is 65,535B

IPv6
- Now 20 years old
- Designed to overcome the limitations of IPv4
- Addresses
  - Address space goes from 2^32 --> 2^128
  - Addresses are written as groups of 4 hexadecimal digits
  - 87ab : 301c : b251 : ...
  - All existing IPv4 addresses can be written like this :
> 0000 : 0000 : 0000 : ffff : 149.89.150.100

MTU
 - ~4.3 billion (2^32)
 - Also referred to as jumbograms

#Aim: Cisco inan hour VII: Adrian's Revenge

###Transport Layer (4)

Computer to computer connection over multiple networks.

Unconcerned with the individual hops of layer 3 traffic.

Each IP address has multiple ports
 - 65,535 ports
 - ports < 1024 are well known, reserved ports
 - Regulated by the Internet Assigned numbers Authority (IANA)
 
###TCP
*Transmission Control Protocol*
- Reliable connection
 - Both sides are verified to receive/send information
 - Guarantees delivery of data
 - Data is considered a continuous stream that arrives in the order it is sent (which may not be true in the upper layers)
 - Connections are established using a 3-way handshake:
  - Server "binds" to a port and waits
 1. Client sends a SYN message to the server
 2. Server sends the client a SYN_ACK message
 3. Client sends an ACK message to the server

| | Read | Write |
|:-:|:--:|:-----:|
|Server | Knows by step 1  | Knows by step 3 |
|Client | Knows by step 2  | Knows by step 2 |

Once this is done, the connection is established and data can flow freely between the two machines

###UDP
*User Datagram Protocol*
- Does not require an explicit connection
- Data is sent as discrete datagrams with a set size (as opposed to a continuous stream)
- Datagrams may be dropped, or received out of order
- UDP connections are faster because they do not need to be reassembled at the other end
- Assumes that any kind of error checking is handled at levels 5-7
