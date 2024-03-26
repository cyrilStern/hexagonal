package io.pmu.race.service;

import io.pmu.race.dto.ParticipantDTO;

import java.util.List;
import java.util.stream.IntStream;

public class ParticipantService {

    public static void controlParticipantNumber(List<ParticipantDTO> participants) throws ParticapantExeption {
        int participantNumbers = participants.size();
        List<Integer> numbersOrdered = participants.stream().map(ParticipantDTO::number).sorted().toList();
        for (int i = 0; i < participantNumbers ; i++) { // zero is not a number for participant
            if (i+1 != numbersOrdered.get(i)) throw new ParticapantExeption(); // one is the minimum number
        }
    }

    //TO DO BENCHMARK
    public static void controlParticipantNumberSecond(List<ParticipantDTO> participants) throws ParticapantExeption {
        int sumOfNumber = participants.stream().map(ParticipantDTO::number).reduce(Integer::sum).orElse(0);
        int sumIteration = IntStream.range(0,participants.size()).sum();
        if (sumIteration != sumOfNumber) throw new ParticapantExeption();
    }

}
