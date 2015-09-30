# agnostic-sql
Java project to write sql for different vendors using an internal Java DSL  
STATUS: Experiment  

## Motivation
This project is motivated by the need to write migrations in Java without using other languages (XML, Ruby, Groovy, etc)
 and by the lack of free alternatives to do so.  

## Goal
Usually there's a problem to this kind of projects in that each database vendor has variations on the SQL syntax that
makes hard to think on abstractions.
We solve that problem focusing in two things:  

- Create an abstraction over SQL constructs, so the intention of a query can be expressed without knowing a specific 
vendor variation  
- Limit the number of possibilities to include only the vendors we use, and the queries we write. This includes
  SQLServer and HSQLDB, supporting their DDL and DML (stored procedures, custom functions, other vendors are not supported yet).

As we use this project we may include more vendors or SQL constructs.   
But as we don't have the resources to support every SQL flavor, that's going to be an on-demand basis.

# Usage
To create an agnostic query you need to get an instance of Asql:  

```
 Asql asql = AsqlBuilder.create();
```

Once you get an instance of this type, you start calling and chaining methods on it, until you get a valid AgnosticStatement.
You use a vendor instance to translate it to a vendor specific SQL string:

```
AgnosticStatement statement = asql.alter("tableName")
                                   .renaming(asql.column("previousName"))
                                   .to("newName")
 
 Vendor.hsqldb().translate(statement) 
```

Which gets you a nice hsqldb DDL statement

> ALTER TABLE tableName ALTER COLUMN previousName RENAME TO newName

If you use sqlserver as a vendor, then you get a different statement (with the same intent)

```
 Vendor.sqlserver().translate(statement) 
```

> EXEC sp_RENAME '[tableName].[previousName]','newName','COLUMN'

Look for more examples at [The showcase test](https://github.com/kfgodel/agnostic-sql/blob/master/src/test/java/ar/com/kfgodel/asql/AsqlShowcaseTest.java)
that should be easy to read, and has most of the supported statements.

## FAQ

- **Do you support vendor X?**  
Probably not right now, we may eventually. If you need it badly (willing to donate) then we can talk about it

- **What if I contribute/fork to your project, will you support it?**  
Yeah, why not? We are only resource constrained, so more help is welcome!

- **You missed this Y features/expression on SQL, will you add it?**  
Let us know about it, and we can try to add it if the cost of doing so is not much, and the value justifies it.
The goal of this project is to serve as a basis for migrations, so anything that is not migration related will
probably we ignored (at least for now)

- **Why do you use non ansi names for datatypes?**  
As we try to abstract vendor variations, we picked certain types that work for us and make them different from
the ansi ones, so we don't confuse them. Most of the times the semantics of those types are good enough for us,
and we tried to name them as we use them.
But you can extend that adding your own if it's not enough for you (just use your one datatype instances).

- **Why don't you use [QueryDSL](http://blog.mysema.com/2011/01/querying-in-sql-with-querydsl.html)**  
We love it, but it doesn't support DDL. The day they include it, we will probably use it.

- **Why don't you use Z framework instead?**  
We don't want to write our migrations using XML, groovy, Ruby, or whatever.  
It's a matter of debate, but in our case, we want to keep our program "language consistent" and also be able 
to reference the types and objects that live with the rest of the code.
In that way we can make our migration smart about the classes we define and how they change.
If we used another language, we will have to create mappings between their language and ours 
(making things a little more complex).

---------
2015-09-29
