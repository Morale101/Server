import socket
from termcolor import colored, cprint

s = socket.socket()  # bydefault it takes ipv4 and tcp/ip protocol
print("Socket Created")

s.bind(('localhost', 14444))

s.listen(3)  # number of clients allowed
print("Waiting for connetion")
print()

while True:

    c, addr = s.accept()
    name = c.recv(1024).decode()

    print(colored(f"Connected with {name} having address {addr}", 'green'))
    print()

    c.send(bytes("Welcome Elysian", "utf-8"))

    c.close()
