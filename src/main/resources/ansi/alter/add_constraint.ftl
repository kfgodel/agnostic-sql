<@compress single_line=true>
ALTER TABLE ${tableName} ADD CONSTRAINT ${constraint.name} <#assign constraintDeclaration=constraint.declaration /><#include "/constraints/_constraintDeclaration.ftl"/>
</@compress>