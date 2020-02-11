<#include "/macros/_renderAsModel.ftl"/>
<@compress single_line=true>
ALTER TABLE <@renderAsModel model=model.table/> ALTER COLUMN <@renderAsModel model=model.columnDeclaration.column />
${" "}TYPE <@renderAsModel model=model.columnDeclaration.columnType/>
<#if model.columnDeclaration.columnType?? >
${" "}USING (<@renderAsModel model=model.columnDeclaration.column />::${model.columnDeclaration.columnType.agnosticName})
</#if>

</@compress>