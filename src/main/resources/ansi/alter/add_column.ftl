<@compress single_line=true>
ALTER TABLE ${tableName} ADD <#include "/columns/_columnDeclaration.ftl"/>
</@compress>