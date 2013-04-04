<%==SIM:Set:private=private==%><%==SIM:Set:protected=protected==%><%==SIM:Set:package= ==%><%==SIM:Set:public=public==%>
package <%==SIM:Element.Namespace==%>;

<%==SIM:ForEach:Imports==%>import <%==SIM:Import.Name==%>;
<%==SIM:EndFor==%>

<%==SIM:ForEach:Element.DocumentationLines==%>//<%==SIM:DocumentationLine==%>
<%==SIM:EndFor==%><%==SIM:Element.Visibility==%> interface <%==SIM:Element.Name==%><%==SIM:If:Element.HasInterfaces==%> extends <%==SIM:ForEach:Element.Interfaces==%><%==SIM:Interface.Name==%><%==SIM:IfNot:IsLastItem==%>, <%==SIM:EndIf==%><%==SIM:EndFor==%><%==SIM:EndIf==%>
{
<%==SIM:ForEach:Element.Attributes==%>
    <%==SIM:ForEach:Attribute.DocumentationLines==%>//<%==SIM:DocumentationLine==%>
    <%==SIM:EndFor==%><%==SIM:Attribute.Visibility==%> <%==SIM:Attribute.Type==%> <%==SIM:Attribute.Name==%> <%==SIM:If:Attribute.HasDefaultValue==%>= <%==SIM:Attribute.DefaultValue==%><%==SIM:EndIf==%>;
<%==SIM:EndFor==%>
<%==SIM:ForEach:Element.Operations==%>
    <%==SIM:ForEach:Operation.DocumentationLines==%>//<%==SIM:DocumentationLine==%>
    <%==SIM:EndFor==%><%==SIM:If:Operation.HasReturnType==%><%==SIM:Operation.ReturnType==%><%==SIM:EndIf==%><%==SIM:IfNot:Operation.HasReturnType==%>void<%==SIM:EndIf==%> <%==SIM:Operation.Name==%>(<%==SIM:ForEach:Operation.Parameters==%><%==SIM:Parameter.Type==%> <%==SIM:Parameter.Name==%><%==SIM:IfNot:IsLastItem==%>, <%==SIM:EndIf==%><%==SIM:EndFor==%>);
<%==SIM:EndFor==%>
}