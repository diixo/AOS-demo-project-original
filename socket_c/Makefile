CC=gcc -DDEBUG
CLIENT=client
SERVER=server


all: $(CLIENT).out $(SERVER).out

%.out : %.c
	$(CC) -o $@ $^	

run_server: $(SERVER).out
	nohup ./$< 65432 > nohup_$(SERVER).log &

run_client: $(CLIENT).out
	nohup echo "HelloWorld"| ./$< localhost 65432 > nohup_$(CLIENT).log

view_result:
	echo "Result of server:"
	cat nohup_server.log
	echo "Result of client:"
	cat nohup_client.log

clean:
	rm -rf $(CLIENT).out $(SERVER).out *.out *.log
