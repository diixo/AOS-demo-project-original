CC=gcc
LIB=-pthread

helloworld_pthreads: helloworld_pthreads.out
	./$<	

producer_consumer_model: producer_consumer_model.out 
	./$<	

pthreads_findmin: pthreads_findmin.out
	./$<	

pthreads_pi: pthreads_pi.out
	./$<	

%.out : %.c
	$(CC) $(LIB) -o $@ $^


clean:
	rm -f *.out 
