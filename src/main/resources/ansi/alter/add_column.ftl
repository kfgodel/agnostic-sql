<#include "/macros/_renderAsModel.ftl"/>
<@compress single_line=true>
ALTER TABLE ${model.tableName} ADD <@renderAsModel model=model.columnDeclaration />
</@compress>