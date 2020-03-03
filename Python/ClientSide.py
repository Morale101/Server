import socket


c = socket.socket()

c.connect(('localhost', 14444))

name = input("Enter your name : ")
c.send(bytes(name, "utf-8"))
# decode is used to convert byte to string
print(c.recv(1024).decode())  # buffersize (length of string it will accept)

c.close()
