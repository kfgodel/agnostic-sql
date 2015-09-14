<#include "/macros/_renderAsModel.ftl"/>
<@compress single_line=true>
ALTER TABLE ${tableName} ALTER COLUMN <@renderAsModel model=columnDeclaration/>
</@compress>