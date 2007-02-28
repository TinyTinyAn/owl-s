package impl.owls.grounding;

import impl.owl.WrappedIndividual;

import org.mindswap.owl.OWLIndividual;
import org.mindswap.owls.grounding.JavaVariable;
import org.mindswap.owls.process.Parameter;
import org.mindswap.owls.vocabulary.MoreGroundings;
import org.mindswap.owls.vocabulary.OWLS;

public class JavaVariableImpl extends WrappedIndividual implements JavaVariable {
	public JavaVariableImpl(OWLIndividual ind) {
		super(ind);
	}

	public String getJavaType() {
		return getPropertyAsString(MoreGroundings.javaType);
	}

	public Parameter getOWLSParameter() {
		return (Parameter) getPropertyAs(OWLS.Grounding.owlsParameter, Parameter.class);
	}

	public void removeJavaType() {
		if (hasProperty(MoreGroundings.javaType))
			removeProperties(MoreGroundings.javaType);
	}

	public void removeOWLSParameter() {
		if (hasProperty(OWLS.Grounding.owlsParameter))
			removeProperties(OWLS.Grounding.owlsParameter);
	}

	public void setJavaType(String type) {
		setProperty(MoreGroundings.javaType, type);
	}

	public void setOWLSParameter(Parameter parameter) {
		setProperty(OWLS.Grounding.owlsParameter, parameter);
	}

}
