package com.assurance.boggle.service;

import com.assurance.boggle.entity.Boggle;
import com.assurance.boggle.entity.BoggleDto;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoggleService {

    private static final String DICTIONARY_FILENAME = "src/main/java/com/assurance/boggle/properties/dictionary.txt";

    public BoggleDto getBoggle() {
        final BoggleDto boggleDto = new BoggleDto();

        final char[][] matrix = new char[][]{{'b', 'o', 'r', 'e'}, {'r', 't', 'a', 'n'}, {'j', 'l', 'o', 'p'}, {'n', 'a', 'v', 'y'}};
        Collections.shuffle(Arrays.asList(matrix));

        try {
            final Boggle boggle = new Boggle(4, matrix, DICTIONARY_FILENAME);
            final List<String> solution = boggle.solve();
            solution.sort((fa, s) -> Integer.compare(s.length(), fa.length()));

            boggleDto.setMatrix(matrix);
            boggleDto.setSolutions(solution.stream().distinct().collect(Collectors.toList()));
        } catch (IOException e) {
            throw new RuntimeException("Boggle dictionary file was not found.");
        }
        return boggleDto;
    }
}
