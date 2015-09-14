<#include "/macros/_renderAsModel.ftl"/>
<@compress single_line=true>
ALTER TABLE ${tableName} ADD COLUMN <@renderAsModel model=columnDeclaration />
</@compress>