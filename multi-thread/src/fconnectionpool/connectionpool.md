## 数据库连接池Demo

DEMO中一共有三个文件:  

ConnectionDriver:   
模拟数据库引擎，负责创建和数据库的连接，以及将数据commit到数据库。  
其中ConnectionHandler使用JDK动态代理，在进入方法为commit时，睡眠100ms。模拟数据库访问操作。  
createConnection方法以ConnectionDriver为基类，创建java.sql.Connection的代理类。  
由于ConnectionDriver没有实现任何Connection的方法，所以只会在commit时，执行代理类的睡眠方法。  

ConnectionPool:
模拟数据库连接池，使用LinkedList存入数据库连接。  
在初始化时，根据初始大小存入对应的数据库连接。  
fetchConnection,是从pool中取出一个连接使用，若传入时间大小为负，使用等待/通知模式。若传入时间大小为正，代入传入时间使用等待/超时模式。  
releaseConnection，是从外部释放连接给pool，此时将连接加入pool的最后，同时通知所有在fetch中等待的请求。

ConnectionPoolTest:
ConnectionRunner在start可用后发起count个操作数据库的请求，超时时间为1s,操作完成后end减一。   
main方法发起了threadCount个请求，在分配完线程后，start解锁，保证所有线程同时开始竞争数据库请求。  
end保证在所有线程都操作完成后，main方法才开始打印最终结果。  
AtomicInteger 保证各个线程在统计数据时不会出现线程安全问题。  
最开始n个线程竞争10个连接，100ms后，前10个线程运行完成归还连接。  
随着线程数量的增加，逐渐有线程无法每次都获取到连接。


