# Extract transform load
Data transformation service

Windows Server
installation prerequisite:

## Installation prerequisite:
- VMWare Player or Workstation Pro
- A version of Windows Server not older than version 2012 R2

## Installing VMware Workstation Pro as a Hypervisor on Windows 10/11

### 1. Download and Installation:

- Download the VMware Workstation Pro installer from the official website.
- Double-click the downloaded file to start the installation process.
- Follow the on-screen instructions to complete the installation.
- Once installed, launch VMware Workstation Pro.

### 2. Creating a Virtual Machine (VM):

- Click on "Create a New Virtual Machine" option in VMware Workstation Pro.
- Select "Typical" configuration for the VM creation process.
- Choose "Installer disc image file (iso)" and browse to the location of the Windows Server 2022 ISO file.
- Proceed with the VM creation wizard, specifying parameters like disk size, RAM, CPU cores, etc.
- Complete the VM creation process by clicking "Finish".

### 3. Installing Windows Server 2022:

- Start the newly created VM.
- Follow the prompts to boot from the Windows Server 2022 ISO.
- Install Windows Server 2022 by following the on-screen instructions, 
  including entering the product key and configuring settings.

### 4. Configuring Networking (Bridged Connection):

- In VMware Workstation Pro, select the VM you created.
- Go to the VM settings.
- Choose the "Network Adapter" option.
- Select "Bridged" mode for networking.
- Save the settings.

### 5. Installing SQL Server:

- Once Windows Server 2022 is installed and network settings are configured, 
  download the SQL Server installation files.
- Run the SQL Server installer on the Windows Server 2022 VM.
- Follow the installation wizard, specifying configurations such as instance name, 
  authentication mode, and data directories.
- Complete the SQL Server installation process.
- 
By following these steps, you have installed VMware Workstation Pro as a hypervisor on Windows 11, 
created a VM with Windows Server 2022, configured networking for the VM to use a Bridged connection, 
and installed SQL Server on the Windows Server 2022 VM.


##  Enable Remote Connections to SQL Server
To allow remote connections to the SQL Server, follow these steps:

#### 1. Access Instance/Node Properties:
   Use SQL Server Management Studio (SSMS) to connect to the SQL Server.
   Right-click on the desired instance and select "Properties".

#### 2. Enable Remote Connections:
   In the properties dialog, navigate to the "Connections" section.
   Ensure that the "Allow remote connections to this server" checkbox is selected. 
   If it's not already selected, enable it.

#### 3. Apply Changes:
   Click "OK" to confirm the changes and close the properties window.

#### 4. Restart SQL Server Service (optional):
   If necessary, restart the SQL Server service to fully apply the changes.

## Configure Table Field Naming Strategy
By default, Hibernate in Spring Boot uses a table field naming strategy called 
"snake_case". If the table names in the database follow a different convention, 
such as "camelCase", you need to configure Hibernate to use the correct strategy.
To do this, you can specify the desired strategy in the Spring Boot configuration 
file (usually application.properties or application.yml) using one of the following 
properties:

#### properties:
spring.jpa.hibernate.naming-strategy=org.hibernate.cfg.ImprovedNamingStrategy
Alternatively, if you're using Spring Boot 2.x or later:

#### properties:
spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
Make sure to include the appropriate Hibernate dependencies in your project and 
verify that the configuration has taken effect by checking the column names in the 
database after restarting the application.