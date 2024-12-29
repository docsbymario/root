package com.docsbymario.root;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class Tests {
    @Mock
    List<String> list;

    @Test
    public void test() {
        List<Executable> exec = new ArrayList<>();
        exec.add(() -> Mockito.verify(list).add("Test"));
        exec.add(() -> Mockito.verify(list).add("Test2"));
        exec.add(() -> Mockito.verify(list).add("Test3"));

        Assertions.assertAll(
                exec
        );
    }
}
