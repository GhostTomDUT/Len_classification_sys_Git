package IBK_Demo;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.lazy.IBk;
import weka.core.Instances;
import weka.core.converters.CSVLoader;
import java.io.File;


/**
 * Created by XGHJOB on 2015/10/21.
 */
public class kNN_Demo {
    public static void main(String[] args) throws Exception
    {
        int k =3;
        CSVLoader atf = new CSVLoader(); //Reads a source that is in arff (attribute relation file format) format.
        File inputFile = new File("Iris_Train.csv");
        atf.setFile(inputFile);
        Instances instancesTrain = atf.getDataSet();
        instancesTrain.setClassIndex(instancesTrain.numAttributes()-1);

        inputFile = new File("Iris_Test.csv");
        atf.setFile(inputFile);
        Instances instancesTest = atf.getDataSet();
        instancesTest.setClassIndex(instancesTest.numAttributes() - 1);



        IBk kNN_classifier = (IBk)Class.forName("weka.classifiers.lazy.IBk").newInstance();//KNN算法分类器
        kNN_classifier.setKNN(k);
        kNN_classifier.buildClassifier(instancesTrain);
        String options[]=new String[1];
        //options[0]="-K";//Use a kernel estimator for numeric attributes rather than a normal distribution.
        //options[0]="-D";//Use supervised discretization to convert numeric attributes to nominal ones.
        //Bayes_classifier.setOptions(options);
        Evaluation eval = new Evaluation(instancesTrain);
        eval.evaluateModel(kNN_classifier, instancesTest);
        System.out.println(eval.toSummaryString("=== Summary kNN ===\n",false));
        System.out.println(eval.toMatrixString("=== Confusion Matrix ===\n"));
    }
}
