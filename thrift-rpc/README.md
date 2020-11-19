## Introduction

The Apache Thrift software framework, for scalable cross-language services development, combines a software stack with a code generation engine to build services that work efficiently and seamlessly between C++, Java, Python, PHP, Ruby, Erlang, Perl, Haskell, C#, Cocoa, JavaScript, Node.js, Smalltalk, OCaml and Delphi and other languages.

<!--
## Setting up your GNU compiler version.(One time operation) 

Since DISCI machine uses CentOS 6.5 and the default GNU compiler version is 4.4 which is outdated , please do the following **only if you have never done this before in your account** :

```bash
source /opt/rh/devtoolset-3/enable
echo "source /opt/rh/devtoolset-3/enable" >> .bashrc
```

Once you have done this on the head node, for both the computing nodes, such as compute-26-1 and compute-26-2, they are already good to go.
-->
## About the code. 

As you can see, there are one python server program and 3 client programs written in 3 different programming languages: python, java and c++. 

First, take a look at `hello.thrift`.

```perl
// Apache Thrift Hello World service IDL

service HelloSvc {
    string hello_func()
}
```

As you can see, it is pretty much similar to the IDL file we've created in JavaCORBA project and SunRPC project. Actually, you can find reference about thrift IDL right here:

[Thrift interface description language](https://thrift.apache.org/docs/idl)


## Interoperability.

Apache Thrift gives you the ability to achieve Interoperability between different OS and different programming languages. Under the hood, the IDL design ensures that the data that is trasmitted over the network for any RPC-call will be consistent regardless of the difference between OS and programming languages. Also, thrift provides libraries for different languages, these libraries follow the marshalling and unmarshalling mechanism, so that the RPC-call can be implemented between different programming languages, and definitely different operating systems. 


## Run the server. 

Since we only installed Apache Thrift on your login machine disci.hpcc.ttu.edu, please use this machine only for your testing.

First, let's generate required code for python according to our thrift IDL. 

```
$ thrift -gen py hello.thrift
```

Now, please run the python server first.

Before running the pyther server, find the line below in the `hello_server.py` code

```python
trans_svr = TSocket.TServerSocket(port=9090)
```

Change the port number to what you want to specify and save the python script.

Suppose you are running your server on `compute-26-1`

```
$ python hello_server.py firstname_lastname &
```

Notice that, by having your firstname_lastname at the end of your command for running server, it would be easy to kill the particular process that you have initiated while not affecting others' server processes. 

## Run the python client.

Then, you can run the python client, to see what happens. 

Before running the python client, search for the following line and modify the hostname and the port number according to your settings, 

```python
trans = TSocket.TSocket("localhost", 9090)
```

For example, you can modify the hostname as `compute-26-1`, on which you were running the server, also you change the port number to that you specified for the server. 

Now you can run the client by the following commands:

```
$ python hello_client.py
```

## Run the C++ client.

Please run the following command to run the C++ version of the client.

Before running the C++ client, search for the following line and modify the hostname and the port number according to your settings, 

```cpp
auto trans_ep = make_shared<TSocket>("localhost", 9090);
```

For example, you can modify the hostname as `compute-26-1`, on which you were running the server, also you change the port number to that you specified for the server. 

Now you can run the client by the following commands:

```
$ make clean
$ make all
$ ./client
```

You should be able to see the same result. 

## Run the Java client.

Please run the following command to compile the Java client:

Before running the Java client, search for the following line and modify the hostname and the port number according to your settings, 

```java
TSocket trans = new TSocket("localhost", 9090);
```

For example, you can modify the hostname as `compute-26-1`, on which you were running the server, also you change the port number to that you specified for the server. 

Now you can run the client by the following commands:

```
$ ant clean
$ ant
```

Then, run it!

```
$ ant run
```

## Kill the server process

After testing, remember to kill the server process that you just initated in order to release the network port back to available status. 

```bash
$ pkill -f firstname_lastname
```

Notice that, by having your firstname_lastname at the end of your command for running server, it would be easy to kill the particular process that you have initiated while not affecting others' server processes. 

## Try to [install](https://thrift.apache.org/docs/install/) Apache Thrift on your own computer. 

If you know about [Docker](https://docs.docker.com), you may even install Apache Thrift in Docker containers, and if you have to containers, you can treat them as two indepedent networked machines, and you can have a sense of distributed thrift application.  

To know more about Thrift, please follow the official tutorial and other resources listed below:

* [Apache Thrift Tutorial(Official)](https://thrift.apache.org/tutorial/)
* [Simple Introduction about Thrift](http://jnb.ociweb.com/jnb/jnbJun2009.html)
* [Apache Thrift Witepaper](http://thrift.apache.org/static/files/thrift-20070401.pdf)