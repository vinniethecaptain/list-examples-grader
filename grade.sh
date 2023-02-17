CPATH='.:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar'

rm -rf student-submission
git clone $1 student-submission
echo 'Finished cloning'

#cp Grade
# cd student-submission
if [[ -e student-submission ]]
then
    cd student-submission
    if [[ -f ListExamples.java ]]
    then
        cp ../TestListExamples.java ../student-submission
        cp -r ../lib ../student-submission
        javac ListExamples.java 2>error-output.txt
        if [[ $? != 0 ]]
        then
            echo 'Please make sure the file can compile'
        else 
            echo 'Compiled successfully'
            javac -cp ".;lib/hamcrest-core-1.3.jar;lib/junit-4.13.2.jar" TestListExamples.java
            java -cp ".;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore TestListExamples > test-output.txt
            OKTEST=`grep "OK" test-output.txt`
            FAILTEST1=`grep "Failures: 1" test-output.txt`
            
            if [[ $OKTEST == 'OK (2 tests)' ]]
            then
                echo '100%'
            elif [[ $FAILTEST1 == 'Tests run: 2,  Failures: 1' ]]
            then
                echo '50%'
            else 
                echo '0%'    
            fi
            
        fi
        
    else
        echo 'Please make sure you submitted the correct file'
        exit
    fi

fi
