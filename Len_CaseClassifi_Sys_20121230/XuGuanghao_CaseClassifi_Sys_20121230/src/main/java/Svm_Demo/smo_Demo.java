package Svm_Demo;

import weka.classifiers.Evaluation;
import weka.classifiers.functions.SMO;
import weka.classifiers.functions.supportVector.Kernel;
import weka.classifiers.functions.supportVector.RBFKernel;
import weka.classifiers.lazy.IBk;
import weka.core.Instances;
import weka.core.converters.CSVLoader;

import java.io.File;

/**
 * Created by XGHJOB on 2015/11/6.
 */
public class smo_Demo {
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

        SMO smo_classifier = new SMO();
        double  gamma = 10.0;
        RBFKernel k1 = new RBFKernel(instancesTrain,0,gamma);
        smo_classifier.setKernel(k1);
        smo_classifier.buildClassifier(instancesTrain);
        Evaluation eval = new Evaluation(instancesTrain);
        eval.evaluateModel(smo_classifier, instancesTest);
        System.out.println("gamma="+gamma);
        System.out.println(eval.toSummaryString("=== Summary smo_svm ===\n",false));
        System.out.println(eval.toMatrixString("=== Confusion Matrix ===\n"));
    }
}

