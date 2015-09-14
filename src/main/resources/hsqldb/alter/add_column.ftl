<#include "/macros/_renderAsModel.ftl"/>
<@compress single_line=true>
ALTER TABLE ${model.tableName} ADD COLUMN <@renderAsModel model=model.columnDeclaration />
</@compress>