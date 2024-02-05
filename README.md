# Retail Data Analysis Project

## Overview
This project focuses on analyzing and gaining insights from a sample retail dataset. The goal is to build big data pipeline that does data processing and analysis to extract valuable information from the retail data.


## Libraries Used
* Cloudera and Hadoop Ecosystem:  Distribution platform for Apache Hadoop and related projects, Used in Managing and deploying Hadoop-based applications.
* Apache Kafka : Distributed event streaming platform. Used in: Setting up a simple demo for real-time data streaming. Installation: Follow the Apache Kafka documentation for setup.
* Apache Hive: Purpose: Data warehousing and SQL-like query language for Hadoop, Used in Storing and querying large datasets in Hadoop.
* Spark SQL : Distributed data processing and analysis, Used in Performing Spark SQL queries.
* HBase: Distributed, scalable, and NoSQL database for Hadoop, Used in: Storing and retrieving large amounts of sparse data.
* PyHive: Python interface to Apache Hive, Used in Connecting Python with Hive for data analysis.
* Matplotlib: Plotting library for creating static visualizations, Used in Data exploration and basic visualizations.
* Jupyter: Interactive computing and data visualization, Used in Creating interactive notebooks for data visualization.

To set up the Retail Data Analysis project, follow the installation instructions for the required tools and libraries. Below are step-by-step instructions for installing the necessary components.

### Prerequisites:

1. **Python:**
   - Ensure that Python is installed on your system. If not, download and install it from [Python's official website](https://www.python.org/).

2. **pip:**
   - Pip is the package installer for Python. It usually comes with Python installations. If not, you can install it by following the instructions on the [official pip website](https://pip.pypa.io/en/stable/installation/).
   
3. **Cloudera virtual Machine**
   - Ensure that you have cloudera virtual machine in your setup. 

4. **Matplotlib:**
   ```bash
   pip install matplotlib
   ```

5. **PyHive:**
   ```bash
   pip install pyhive
   ```

5. **Jupyter:**
   ```bash
   pip install jupyter
   ```

6. **Apache Kafka 3.13:**
   - Follow the instructions to download and install Apache Kafka from the [official Apache Kafka website](https://kafka.apache.org/downloads) Do it on the virtual machine.

Ensure that all installations are successful before proceeding with the project.

## Run The Project

1. Source Kafka Start Script
```
source start-kafka.sh

```

2. Run Kafka Producer Project
3. Ensure Consumer Project JAR Exists
    - Make sure the consumer project JAR file is available on the desktop of the virtual machine.

4. Source HBase Table Creation Script
```
source hbase_table_create.sh
```
5. Source Spark Submit Script

```
source spark_submit.sh
```

6. Load the data into hive to be used in the visualization later
```
source dump.sh
```

7. Get VM IP Address

    - Retrieve the IP address of the virtual machine.
```
ip a 
```

8. Update the visualization project with the correct IP address to connect with Hive.

9. Run Jupyter Notebook

```
jupyter notebook
```

10. Execute the necessary code snippets within the Jupyter Notebook.
## Authors

- [Karam ](https://www.github.com/octokatherine)
- [Majed ](https://www.github.com/octokatherine)
- [Abduallah ](https://www.github.com/octokatherine)
- [Mahmoud ](https://www.github.com/octokatherine)
