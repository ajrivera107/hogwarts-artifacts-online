package edu.tcu.cs.hogwartsartifactsonlinecda.artifact.converter;

import edu.tcu.cs.hogwartsartifactsonlinecda.artifact.Artifact;
import edu.tcu.cs.hogwartsartifactsonlinecda.artifact.dto.ArtifactDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ArtifactDtoToArtifactConverter implements Converter<ArtifactDto, Artifact> {



    @Override
    public Artifact convert(ArtifactDto source) {
        Artifact artifact = new Artifact();
        artifact.setId(source.id());
        artifact.setName(source.name());
        artifact.setDescription(source.description());
        artifact.setImageUrl(source.imageUrl());

        return artifact;
    }
}
