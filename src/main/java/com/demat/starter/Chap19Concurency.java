package com.demat.starter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.util.Collections.synchronizedCollection;

/**
 * @author TNAJI Khalid
 */
public class Chap19Concurency {
    public static void Demo() {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread 1");
            }
        };
        Thread t1 = new Thread(runnable);

        Callable callable = new Callable() {
            @Override
            public Object call() throws Exception {
                return null;
            }
        };
        try {
            callable.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ExecutorService executorService1 = Executors.newSingleThreadExecutor();

        executorService.execute(runnable);

        //when passing Runnable, get() returns null if the task is complete
        //• with Callable, get() returns the matching generic type
        Future<?> submitRunnable = executorService.submit(runnable);
        Future submitCallable = executorService.submit(callable);




        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        Runnable taskOne = () -> System.out.println("Hello!");
        Callable<String> taskTwo = () -> "Hi!";
        ScheduledFuture<?> resultOne = service.schedule(taskOne, 20, TimeUnit.SECONDS);
        ScheduledFuture<?> resultTWo = service.schedule(taskTwo, 15, TimeUnit.MINUTES);

        ScheduledFuture<?> scheduledFuture = service
                .scheduleAtFixedRate(runnable, 15L, 1L, TimeUnit.SECONDS);
        service.scheduleAtFixedRate(callable, 15L,1L, TimeUnit.SECONDS);
            service.scheduleWithFixedDelay(runnable, 15L,1L, TimeUnit.SECONDS);


            /*
Synchronized Access
• atomic classes protect single variable
• synchronized access protects series of commands (block)
• a structure called monitor (or lock) supports mutual exclusion
• while the block is running, no other thread can interfere
• any object can be used as a monitor (existing or new one)
• when thread tries to run the block it rst checks if any other thread is running it
• if lock is not available, the thread will transition to BLOCKED state
• after the thread "acquires the lock", the single thread will enter the block
• while the block is executed all other threads will be prevented from entering
             */
        // synchronized block (syntax)
        var lock = new Object();
        synchronized(lock) {
            // code which needs to be executed
            // one thread at a time
        }

    }

    // synchronized methods
    // first way
    void doSomething() {
        synchronized(this) { //current class (this) is used as a lock
            // work to be executed one thread at a time
        }
    }

    // alternative
    synchronized void doSomething2() {
        // work to be executed one thread at a time
    }

    /*
    ReentrantLock
• part of Lock interface which allows manual control over monitors
• for example, it's useful when we want to check if lock is available
• and then maybe do something else in case it's not
• to protect a part of code* call lock() method
*to make it unavailable to other threads while one thread is using it
• to make ti available to other threads call unlock() method
     */

    void demo2(){
        // using ReentrantLock
        Lock myLock = new ReentrantLock();
        try {
            myLock.lock();
            // work to be executed one thread at a time
        } finally {
            myLock.unlock();
        }
        // this is equivalent to using synchronized block,
        // but it gives you more control over the access




        /*
        CyclicBarrier
• CyclicBarrier class takes in its constructor a limit value
• indicating the number of threads to wait for
• as each thread nishes it calls the await() method on cyclic barrier
• once the specic number of threads have each called await()
• the barrier is released, and all threads can continue
         */
    }

    public static void cyclicBarrierEx() {
        CyclicBarrier barrier = new CyclicBarrier(3); // Barrier for 3 parties
        Runnable workerTask = () -> {
            String name = Thread.currentThread().getName();
            System.out.println(name + " is performing the first part of the work.");
            try {
                barrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            // code to follow will be performed only after 3 threads finish with the execution of the code above
            System.out.println(name + " is performing the remaining work after the barrier.");
        };

        Thread worker1 = new Thread(workerTask, "Worker 1");
        Thread worker2 = new Thread(workerTask, "Worker 2");
        Thread worker3 = new Thread(workerTask, "Worker 3");
        Thread worker4 = new Thread(workerTask, "Worker 4");

        worker1.start();
        worker2.start();
        worker3.start();
        worker4.start();

    }

    void demo3() {
        /*
        ConcurrentHashMap:  Map, ConcurrentMap
        ConcurrentLinkedQueue:  Queue
        ConcurrentSkipListMap:  Map, SortedMap, NavigableMap, ConcurrentMap, ConcurrentNavigableMap
        ConcurrentSkipListSet:  Set, SortedSet, NavigableSet
        CopyOnWriteArrayList:  List
        CopyOnWriteArraySet:  Set
        LinkedBlockingQueue:  Queue, BlockingQueue

         */

        Collection<String> objects = synchronizedCollection(new ArrayList<>());
        /*
        synchronizedList(List<T> list)
        synchronizedMap(Map<K,V> m)
        synchronizedNavigableMap(NavigableMap<K,V> m)
        synchronizedNavigableSet(NavigableSet<T> s)
        synchronizedSet(Set<T> s)
        synchronizedSortedMap(SortedMap<K,V> m)
        synchronizedSortedSet(SortedSet<T> s)
         */



        // Threads Problems

        /*
        Deadlock
• two or more threads are blocked forever
• because each thread is waiting on the other to complete
         */

        /*
        Starvation
• a single thread is perpetually denied access to a shared resource or a lock
• the thread is still active, but is unable to complete its work
• because other thread(s) are constantly taking the resource it's trying to access
         */

        /*
        Livelock
• two or more threads are conceptually blocked forever
• even thought each of them are active and is trying to complete its task
• this is special case of resource starvation:
• two or more threads actively try to acquire a set of locks
• and since they are unable to do so, the process is restarted
• in practice, livelock is dicult issue to detect
• because threads in livelock state appear active and resposnive
• but actually they are just stuck in an endless state
         */

        /*
        Race Condition
• two tasks that should be completed sequentially are completed at the same time
• most common example is creation of unique username:
• either both users will create an account with the same username
• or neither user will be able to create an account and will get an error
• or one user will be allowed a username, and other one will get an error
• neither of these outcomes are desirable
         */
    }
}
