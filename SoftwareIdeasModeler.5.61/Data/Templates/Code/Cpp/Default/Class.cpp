<%==SIM:Set:private=private==%>
<%==SIM:Set:protected=protected==%>
<%==SIM:Set:package=internal==%>
<%==SIM:Set:public=public==%>
<%==SIM:ForEach:Imports==%>
#include <%==SIM:Import.Name==%>;
<%==SIM:EndFor==%>

//<%==SIM:Element.Documentation==%>
class <%==SIM:Element.Name==%><%==SIM:If:Element.HasSuperClass==%> : public <%==SIM:Element.SuperClass.Name==%><%==SIM:EndIf==%>
{
<%==SIM:ForEach:Element.Attributes==%>
<%==SIM:Attribute.Visibility==%>:
	<%==SIM:If:Attribute.IsStatic==%> static <%==SIM:EndIf==%><%==SIM:Attribute.Type==%> <%==SIM:Attribute.Name==%>;
<%==SIM:EndFor==%>


<%==SIM:ForEach:Element.Operations==%>
<%==SIM:Operation.Visibility==%>:
	<%==SIM:If:Operation.IsStatic==%> static <%==SIM:EndIf==%><%==SIM:If:Operation.IsVirtual==%> virtual <%==SIM:EndIf==%><%==SIM:If:Operation.HasReturnType==%><%==SIM:Operation.ReturnType==%><%==SIM:EndIf==%><%==SIM:IfNot:Operation.HasReturnType==%>void<%==SIM:EndIf==%> <%==SIM:Operation.Name==%> (<%==SIM:ForEach:Operation.Parameters==%><%==SIM:Parameter.Type==%> <%==SIM:Parameter.Name==%><%==SIM:IfNot:IsLastItem==%>, <%==SIM:EndIf==%><%==SIM:EndFor==%>) 
    {

    }

<%==SIM:EndFor==%>
};