package at.test.drm;

import at.drm.factory.RelationDaoFactory;
import at.drm.service.RelationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class RelationServiceTest {

    @Mock
    private RelationDaoFactory relationDaoFactory;

    @Mock
    private AnnotationTestRelationDao annotationTestRelationDao;

    @InjectMocks
    private RelationService relationService;

    @Test
    void createRelation() {
        Mockito.when(relationDaoFactory.getDaoFromSourceObjectClass(any(Class.class)))
                .thenReturn(annotationTestRelationDao);
        AnnotationTest annotationTest = new AnnotationTest();
        annotationTest.setId(1L);
        AnnotationTest2 annotationTest2 = new AnnotationTest2();
        annotationTest2.setId(1L);
        relationService.createRelation(annotationTest, annotationTest2);
    }

    @Test
    void deleteRelation() {
        Mockito.when(relationDaoFactory.getDaoFromSourceObjectClass(any(Class.class)))
                .thenReturn(annotationTestRelationDao);
        AnnotationTestRelation annotationTestRelation = new AnnotationTestRelation();
        annotationTestRelation.setSourceObject(new AnnotationTest());
        relationService.deleteRelation(annotationTestRelation);
    }

}