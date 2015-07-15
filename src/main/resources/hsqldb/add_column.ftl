<@compress single_line=true>
ALTER TABLE ${tableName} ADD COLUMN <#include "_columnDeclaration.ftl"/>
</@compress>