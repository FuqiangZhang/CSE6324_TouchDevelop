package test;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Map;

import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.compiler.IProblem;
import org.eclipse.jdt.core.dom.*;
public class JDTTest {

	public static void main(String[] args) {
	    ASTParser parser = ASTParser.newParser(AST.JLS4); //设置Java语言规范版本
	    parser.setKind(ASTParser.K_COMPILATION_UNIT);

	    Map<String, String> compilerOptions = JavaCore.getOptions();
	    compilerOptions.put(JavaCore.COMPILER_COMPLIANCE, JavaCore.VERSION_1_7); //设置Java语言版本
	    compilerOptions.put(JavaCore.COMPILER_CODEGEN_TARGET_PLATFORM, JavaCore.VERSION_1_7);
	    compilerOptions.put(JavaCore.COMPILER_SOURCE, JavaCore.VERSION_1_7);
	    parser.setCompilerOptions(compilerOptions); //设置编译选项
	    FileReader fr = null;
	    try {
			 fr = new FileReader(new File("c://Struct.java"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    char[] src =new char[1024*100];
	    
	    try {
			fr.read(src);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    parser.setSource(src);
	    CompilationUnit cu = (CompilationUnit) parser.createAST(null); //这个参数是IProgessMonitor,用于GUI的进度显示,我们不需要，填个null. 返回值是AST的根结点
	    
	    
	    ASTVisitor visitor = new ASTVisitor() {
	        @Override
	        public boolean visit(MethodInvocation mi) {
	            if (mi.getExpression() instanceof ThisExpression) {
	                mi.setExpression(null);
	                System.out.println(mi.getName());
	            }
	            return true;
	        }
	    };
	    cu.accept(visitor);
	    
	    System.out.println(cu.toString());
	    IProblem[] ip = cu.getProblems();
	    System.out.println(ip[0].toString());
	    
	}
}
