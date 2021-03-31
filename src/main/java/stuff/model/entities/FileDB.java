package stuff.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "files")
public class FileDB extends BaseEntity{

    private String fileName;
    private String fileType;


    private byte [] data;

    public FileDB() {
    }

    public FileDB(String fileName, String fileType, byte[] data) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
    }

    @Column(name = "file_name", nullable = false)
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    @Column(name = "file_type", nullable = false)
    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
    @Lob
    @Column(name = "data", nullable = false)
    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
