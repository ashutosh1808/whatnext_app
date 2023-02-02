# whatnext_app


## MySQL Part

To deploy this project run

```bash
  mysql -u[uname] -p[passwd]

  mysql> use kc_2feb23;
  mysql> create table student(name varchar(20), 
        -> choice varchar(10)
        -> );
```


## Compile and run

To run tests, run the following command

```bash
  javac -cp ../ashu/* A1Test.java
```
```bash
  java -cp ../ashu/*;. A1Test
```


