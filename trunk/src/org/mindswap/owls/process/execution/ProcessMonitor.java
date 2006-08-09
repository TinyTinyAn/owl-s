/*
 * Created on Jun 27, 2005
 */
package org.mindswap.owls.process.execution;

import org.mindswap.exceptions.ExecutionException;
import org.mindswap.query.ValueMap;
import org.mindswap.owls.process.Process;

/**
 * An interface that descriubes functions to monitor process execution
 * 
 * @author Evren Sirin
 *
 */
public interface ProcessMonitor {
    /**
     * Called only once when the execution of the top-most process starts
     */
    public void executionStarted();
    
    /**
     * Called only once when the execution of the top-most process finishes. Note that
     * if execution fails for any reason this function will not be called. Instead
     * executionFailed() will be called.
     */
    public void executionFinished();
    
    /**
     * Called before the execution of a process starts. The user has the option to 
     * modify the contents of the inputs. setMonitorFilter function can be used to 
     * control if this function will be called for all the processes or only for
     * a specific type of processes (e.g. only atomic processes).
     * 
     * @param process
     * @param inputs
     */
    public void executionStarted(Process process, ValueMap inputs);
    
    /**
     * Called after the execution of a process finishes. The user has the option to 
     * modify the contents of outputs. setMonitorFilter function can be used to 
     * control if this function will be called for all the processes or only for
     * a specific type of processes (e.g. only atomic processes). 
     * 
     * @param process
     * @param inputs
     * @param outputs
     */
    public void executionFinished(Process process, ValueMap inputs, ValueMap outputs);
    
    /**
     * Called when the execution fails due to an execption. This function is intended
     * to be hook where the user can do something to fix the problem, i.e. ask for
     * additional inputs. There is no such support at the moment. The execution engine 
     * will throw the exception right after this function returns.  
     * 
     * @param e
     */
    public void executionFailed(ExecutionException e);
    
    /**
     * Control if executionStarted and executionFinished will be called for all the 
     * processes or only for a specific type of processes. The constant values are 
     * defined in Process interface:
     * <p>
     * <ul>
     * <li><code>Process.ANY</code></li>
     * <li><code>Process.ATOMIC</code></li>
     * <li><code>Process.COMPOSITE</code></li>
     * <li><code>Process.SIMPLE</code></li>
     * </ul>  
     * </p>
     * Bitwise combinations (<code>bitwise or</code>) of these values are also valid.
     * 
     * @param processType
     */
    public void setMonitorFilter(int processType);
    
    public int getMonitorFilter();
}
