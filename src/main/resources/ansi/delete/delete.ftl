<@compress single_line=true>
DELETE FROM ${tableName}<#include "/restrictions/_wherePredicate.ftl" />
</@compress>