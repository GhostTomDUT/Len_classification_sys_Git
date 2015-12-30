package RandomForest;

import weka.classifiers.Evaluation;
import weka.classifiers.functions.LibSVM;
import weka.classifiers.trees.RandomForest;
import weka.core.Instances;
import weka.core.converters.CSVLoader;

import java.io.File;

/**
 * Created by XGHJOB on 2015/11/13.
 */
public class RF_Demo {
    public static void main(String[] args) throws Exception
    {
    CSVLoader loader = new CSVLoader(); //Reads a source that is in arff (attribute relation file format) format.
    File inputFile = new File("H:\\Data_Mining\\Java\\workspace\\XuGuanghao_CaseClassifi_Sys_W3\\Data\\Iris_Train.csv");
    loader.setSource(inputFile);//设置读取路径
    Instances instancesTrain = loader.getDataSet();//将数据集完整的传给instances
    instancesTrain.setClassIndex(instancesTrain.numAttributes()-1);//选择最后一列作为类别属性
    inputFile = new File("H:\\Data_Mining\\Java\\workspace\\XuGuanghao_CaseClassifi_Sys_W3\\Data\\Iris_Test.csv");
    loader.setFile(inputFile);
    Instances instancesTest = loader.getDataSet();
    instancesTest.setClassIndex(instancesTest.numAttributes() - 1);

    RandomForest RF_classifier = new RandomForest();
    RF_classifier.buildClassifier(instancesTrain);
    Evaluation eval = new Evaluation(instancesTrain);
    eval.evaluateModel(RF_classifier, instancesTest);
    System.out.println(eval.toSummaryString("=== Summary libsvm_svm ===\n",false));
    System.out.println(eval.toMatrixString("=== Confusion Matrix ===\n"));
    System.out.println(eval.toClassDetailsString("=== ClassDetails ===\n"));
    System.out.println(eval.totalCost());
    }
}

