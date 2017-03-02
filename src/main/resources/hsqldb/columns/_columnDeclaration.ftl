<@renderAsModel model=model.column /> <@renderAsModel model=model.columnType />
<#if model.defaultValue??>
DEFAULT <@renderAsModel model=model.defaultValue />
</#if>
<#if model.nullability??>
 <@renderAsModel model=model.nullability />
</#if>
