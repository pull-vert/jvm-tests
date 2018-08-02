package jvm.gen.initial;

import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeSpec;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VariousPoetTest {

    private final String testPackage = "jvm.test";

    private String toString(TypeSpec typeSpec) {
        return JavaFile.builder(testPackage, typeSpec).build().toString();
    }

    @Test
    public void codeBlockVarString() {
        CodeBlock codeBlock = CodeBlock.builder()
                .addStatement("var $N = $S.substring(0, 3)", "s", "cat")
                .build();
        assertThat(codeBlock.toString()).isEqualTo("var s = \"cat\".substring(0, 3);\n");
    }

    @Test
    public void codeBlockVarInt() {
        CodeBlock codeBlock = CodeBlock.builder()
                .addStatement("var $N = $N", "i", "12")
                .build();
        assertThat(codeBlock.toString()).isEqualTo("var i = 12;\n");
    }
}
