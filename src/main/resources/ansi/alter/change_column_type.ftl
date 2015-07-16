<@compress single_line=true>
ALTER TABLE ${tableName} ALTER COLUMN <#include "/columns/_columnDeclaration.ftl"/>
</@compress>