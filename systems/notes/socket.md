#Aim: Socket to me!

`socket( <kind of IP address (IPv4, IPv6)>, <type of connection (TCP)> , <kind of protocol, 0 for OS auto-choose> );``
socket( AF_INET, SOCK_STREAM, 0);`

Creates a socket, just lets OS know that there IS a socket

`bind(socket_id, sockaddr_listener, listener size );`
`bind(socket_id, (struct sockaddr *)&listener, sizeof(listener)); //puts IP address information into the socket`

