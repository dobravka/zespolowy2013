<%==SIM:Set:private=Private==%>
<%==SIM:Set:protected=Protected==%>
<%==SIM:Set:package=Friend==%>
<%==SIM:Set:public=Public==%>

<%==SIM:ForEach:Imports==%>
require '<%==SIM:Import.Name==%>'
<%==SIM:EndFor==%>

<%==SIM:ForEach:Element.DocumentationLines==%># <%==SIM:DocumentationLine==%>
<%==SIM:EndFor==%>module <%==SIM:Element.Namespace==%>
    class <%==SIM:Element.Name==%><%==SIM:If:Element.HasSuperClass==%><<%==SIM:Element.SuperClass.Name==%><%==SIM:EndIf==%>

		attr_accessor <%==SIM:ForEach:Element.Attributes==%>:<%==SIM:Attribute.Name==%><%==SIM:IfNot:IsLastItem==%>, <%==SIM:EndIf==%><%==SIM:EndFor==%>

<%==SIM:ForEach:Element.Operations==%>
		def <%==SIM:Operation.Name==%> (<%==SIM:ForEach:Operation.Parameters==%><%==SIM:Parameter.Name==%><%==SIM:IfNot:IsLastItem==%>, <%==SIM:EndIf==%><%==SIM:EndFor==%>)

		end
<%==SIM:EndFor==%>
    end
end