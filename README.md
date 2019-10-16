# agnostic-sql
Java project to write sql using a Java DSL that is agnostic from each vendor idiom.
By using this DSL a query can be defined and later be translated to any of the supported 
vendors
  
STATUS: Experiment  

## Motivation
This project is motivated by the need to write migrations in Java without using other 
languages (XML, Ruby, Groovy, etc) and doing so without having to write something different
for each database vendor. (Also by the lack of free alternatives to do so).  

## Scope
Usually there's a problem to this kind of projects in that each database vendor has 
variations on the SQL syntax that makes it hard to think on abstractions.
We solve that problem focusing in two things:  

- Create an abstraction over SQL constructs, so the intention of a query can be 
  expressed without knowing the details of an specific vendor (ANSI is taken as the 
  base model)  

- Limit the scope of what can be expressed with the DSL to the vendors we usually need
  and the queries we usually write for migrations. This includes SQLServer and HSQLDB, 
  supporting their DDL and DML (stored procedures, custom functions, or other vendors 
  are not supported yet).  

As we use this project on real life projects we may include more vendors or SQL 
constructs.   
But as we don't have the resources to support every SQL flavor, that's going to be 
an on-demand basis.

# Usage
To start using the DSL you need an instance of the builder:  

```
 Asql asql = AsqlBuilder.create();
```

Once you get an instance of this type, you start calling and chaining methods on it, 
until you get a valid AgnosticStatement.
You use a vendor instance to translate it to a vendor specific SQL string:

```
AgnosticStatement statement = asql.alter("tableName")
                                   .renaming(asql.column("previousName"))
                                   .to("newName")
 
 Vendor.hsqldb().translate(statement) 
```

Which gets you a nice hsqldb DDL statement

> ALTER TABLE tableName ALTER COLUMN previousName RENAME TO newName

If you use sqlserver as a vendor, then you get a different statement (with the same 
intent)

```
 Vendor.sqlserver().translate(statement) 
```

> EXEC sp_RENAME '[tableName].[previousName]','newName','COLUMN'

Look for more examples at [The showcase test](https://github.com/kfgodel/agnostic-sql/blob/master/src/test/java/ar/com/kfgodel/asql/AsqlShowcaseTest.java).  
It should be easy to follow, and has most of the supported statements.

## FAQ

- **Do you support vendor X?**  
  Probably not right now, we may eventually. If you need it badly then we can talk 
  about it. Are you willing to collaborate?  

- **What if I contribute/fork to your project, will you support it?**  
  Yeah, why not? We are only resource constrained, so more help is welcome!

- **You missed this Y features/expression on SQL, will you add it?**  
  Let us know about it, and we can try to add it if the cost of doing so is not much 
  and it's something that can be expressed in many vendors.
  The goal of this project is to serve as a basis for migrations, so anything that is 
  not migration related will probably we ignored (at least for now)  

- **Why do you use non-ansi names for datatypes?**  
  As we try to abstract vendor variations we need names that are intuitive enough
  and at the same time don't collide with java keywords.
  However, they may be misleading. Let us know what you think of them, or if you
  have suggestions for improving them.  
  You can also extend built-in types adding your own (just use your one datatype 
  instances).  

- **Why don't you use [QueryDSL](http://blog.mysema.com/2011/01/querying-in-sql-with-querydsl.html)**  
  We love QueryDSL but it doesn't support DDL. The day they include it, we will probably 
  drop this project.

- **Why don't you use Z framework instead?**  
  We don't want to write our Java migrations using XML, groovy, Ruby, or anything 
  other than Java.  
  It's a matter of debate, but in our case, we want to keep our program 
  "language consistent" and also be able to reference the types and objects that 
  live with the rest of the code.  
  In that way we can make our migrations smart about the classes we define and how 
  they change. And we can build abstractions over the migrations using the same tools.  
  If we used another language, we will have to create mappings between that language
  and Java (making things a little more complex).

---------
2015-09-29
