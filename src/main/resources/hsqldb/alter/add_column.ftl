<@compress single_line=true>
ALTER TABLE ${tableName} ADD COLUMN <#include "/columns/_columnDeclaration.ftl"/>
</@compress>