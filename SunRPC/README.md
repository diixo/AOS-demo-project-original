# Introduction

This is a simple demonstration on ONC RPC by Sun Microsystems. 

# Related Documents:

[rpcgen Programming Guide](https://docs.freebsd.org/44doc/psd/22.rpcgen/paper.pdf)

[ONC+ Developer's Guide](http://docs.oracle.com/cd/E19683-01/816-1435/index.html)

[File Tranfer via SunRPC](https://stackoverflow.com/questions/20300357/file-transfer-using-rpcany-type-of-file)


# Instruction on code generating and executing:

#### 1. Prepare a RPC Language program (file named test.x)

```perl
program TESTPROG {
   version VERSION {
     string TEST(string) = 1;
   } = 1;
} = 87654321;
```

**Note:**

  * `87654321` RPC ID
  * string TEST(string) = 1  :  return a string parameter.

#### 2. execute the following to generate 3 files: `test_clnt.c`  `test.h`  `test_svc.c`

```bash
   $ rpcgen test.x
```

#### 3. execute the following to generate `test_clnt_func.c`

```bash
   $ rpcgen -Sc -o 'test_clnt_func.c' test.x
```

#### 4. execute the following to generate `test_srv_func.c`

```bash
   $ rpcgen -Ss -o 'test_srv_func.c' test.x
```

#### 5.  replace  `test_srv_func.c`  with the following

```c
#include <time.h>
#include "test.h"
char ** test_1_svc(char **argp, struct svc_req *rqstp)
{
        static char * result;
        static char tmp_char[128];
        time_t rawtime;
        /*
         * insert server code here
         */
        if( time(&rawtime) == ((time_t)-1) ) {
                strcpy(tmp_char, "Error");
                result = tmp_char;
                return &result;
        }
        printf("Server processed request when time is  :%s", ctime(&rawtime));
	    fflush(stdout);
        sprintf(tmp_char, "Server time is  :%s", ctime(&rawtime));
        result = tmp_char;
        return &result;
}
```

##### Compile:

```bash
$ gcc -Wall -o test_server test_clnt.c test_srv_func.c test_svc.c
```

#### 6. replace the function testprog_1 of test_clnt_func.c with the following

```c
void testprog_1(char *host)
{
        CLIENT *clnt;
        char * *result_1;
        char * test_1_arg;
        test_1_arg = (char *)malloc(128);
#ifndef DEBUG
        clnt = clnt_create (host, TESTPROG, VERSION, "udp");
        if (clnt == NULL) {
                clnt_pcreateerror (host);
                exit (1);
        }
#endif  /* DEBUG */
        result_1 = test_1(&test_1_arg, clnt);
        if (result_1 == (char **) NULL) {
                clnt_perror (clnt, "call failed");
        }
        if (strcmp(*result_1, "Error") == 0) {
                fprintf(stderr, "%s: could not get the time\n", host);
                exit(1);
        }
        printf("Receive message ... %s\n", *result_1);
#ifndef DEBUG
        clnt_destroy (clnt);
#endif   /* DEBUG */
}
```

##### Compile :

```bash
$ gcc -Wall -o test_client test_clnt_func.c test_clnt.c
```

#### 7. Start server

```bash
$ nohup ./test_server > server.log &
```

#### 8. Start client

```bash
$ ./test_client 127.0.0.1
```

**Note** : The argument that you can pass to the client must be a valid IP address or a valid hostname. 