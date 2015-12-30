package Bayes_Demo;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.Instances;
import weka.core.converters.CSVLoader;

import java.io.File;

/**
 * Created by XGHJOB on 2015/10/21.
 */
public class NavieBayes
{
        public static void main(String[] args) throws Exception
        {
            CSVLoader atf = new CSVLoader(); //Reads a source that is in arff (attribute relation file format) format.
            File inputFile = new File("H:\\Data_Mining\\Java\\workspace\\XuGuanghao_CaseClassifi_Sys_W4\\Data\\trainset.csv");
            atf.setFile(inputFile);
            Instances instancesTrain = atf.getDataSet();
            instancesTrain.setClassIndex(instancesTrain.numAttributes()-1);


            inputFile = new File("H:\\Data_Mining\\Java\\workspace\\XuGuanghao_CaseClassifi_Sys_W4\\Data\\testset.csv");
            atf.setFile(inputFile);
            Instances instancesTest = atf.getDataSet();
            instancesTest.setClassIndex(instancesTest.numAttributes() - 1);
            Classifier Bayes_classifier = new NaiveBayes();
            String options[]=new String[1];
            //options[0]="-K";//Use a kernel estimator for numeric attributes rather than a normal distribution.
            //options[0]="-D";//Use supervised discretization to convert numeric attributes to nominal ones.
            //Bayes_classifier.setOptions(options);
            Bayes_classifier.buildClassifier(instancesTrain);
            Evaluation eval = new Evaluation(instancesTrain);
            eval.evaluateModel(Bayes_classifier, instancesTest);
            System.out.println(eval.toSummaryString("=== Summary_Bayes ===\n",false));
            System.out.println(eval.toMatrixString("=== Confusion Matrix ===\n"));
        }
    }
