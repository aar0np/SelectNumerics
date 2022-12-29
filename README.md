# SelectNumerics

A simple Java program to query different numeric types from Apache Cassandra

## Prerequisites

### Apache Cassandra
 - Running locally
 - Accepting connections on 9042
 - Keyspace named "stackoverflow"

### Cassandra table definition

```sql
CREATE TABLE numerics (
    num INT PRIMARY KEY,
    dec DECIMAL,
    doub DOUBLE,
    flt FLOAT);
```

With data...
```sql
INSERT INTO numerics (num,dec,doub,flt) VALUES (1,1.01,1.01,1.01);
```

### Environment Variables

These should both be set (`export`ed) before running.
 - `CASSANDRA_USER` - The username to connect as.
 - `CASSANDRA_PASS` - The password of the specified username.

