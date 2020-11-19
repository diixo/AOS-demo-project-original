# Introduction

This is a very simple program demonstrating the use of Java IDL technology.
You may follow the document below to understand how does it work:

[Getting Started with Java™ IDL](http://docs.oracle.com/javase/7/docs/technotes/guides/idl/GShome.html)

[Java™ IDL (CORBA)](http://docs.oracle.com/javase/7/docs/technotes/guides/idl/)

# Checkout and run the code:

On your home folder, please run the following commands to check out the code that we provided:
```
git clone "http://discl.cs.ttu.edu/gitlab/zhangwei217245/AOS-demo-project.git"
```

Then, you may follow the link below to get an idea on how to execute the provided code. 

[Java IDL: The "Hello World" Example](http://docs.oracle.com/javase/7/docs/technotes/guides/idl/jidlExample.html)

## Remember: 
As for the code, please follow the version we provide you, not the ones on the above webpage, since we include some bugfixes and extra comments for you to sharp your mind. 
After following the tutorial and executing the code, think about the three questions written in the inline comments. 

## Notice: 
As for the port number that you provide for communication, try to avoid any port numbers that other programs are using. Our suggestions are as follows:
* Try `netstat -natlp|awk '{print $4}'|awk -F':' '{print $NF}'|sort -n|uniq` to see which port numbers are taken. 
* Only use port numbers range 60000~65534 to avoid conflict of port numbers.


