package ca.uhn.fhir.jpa.model.entity;

import ca.uhn.fhir.context.FhirVersionEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity()
@Table(name = "NPM_PACKAGE_VER_RES", uniqueConstraints = {
}, indexes = {
	@Index(name = "IDX_PACKVERRES_URL", columnList = "CANONICAL_URL")
})
public class NpmPackageVersionResourceEntity {

	public static final int VERSION_ID_LENGTH = 200;

	@Id
	@SequenceGenerator(name = "SEQ_NPM_PACKVERRES", sequenceName = "SEQ_NPM_PACKVERRES")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_NPM_PACKVERRES")
	@Column(name = "SP_ID")
	private Long myId;
	@ManyToOne
	@JoinColumn(name = "PACKVER_PID", referencedColumnName = "PID", foreignKey = @ForeignKey(name = "FK_NPM_PACKVERRES_PACKVER"))
	private NpmPackageVersionEntity myPackageVersion;
	@OneToOne
	@JoinColumn(name = "BINARY_RES_ID", referencedColumnName = "RES_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_NPM_PKVR_RESID"))
	private ResourceTable myResourceBinary;
	@Column(name = "FILE_DIR", length = 200)
	private String myDirectory;
	@Column(name = "FILE_NAME", length = 200)
	private String myFilename;
	@Column(name = "RES_TYPE", length = ResourceTable.RESTYPE_LEN)
	private String myResourceType;
	@Column(name = "CANONICAL_URL", length = 200)
	private String myCanonicalUrl;
	@Column(name = "CANONICAL_VERSION", length = 200)
	private String myCanonicalVersion;
	@Column(name = "FHIR_VERSION_ID", length = NpmPackageVersionEntity.FHIR_VERSION_LENGTH, nullable = false)
	private String myFhirVersionId;
	@Enumerated(EnumType.STRING)
	@Column(name = "FHIR_VERSION_NAME", length = NpmPackageVersionEntity.FHIR_VERSION_LENGTH, nullable = false)
	private FhirVersionEnum myFhirVersionName;
	@Column(name = "res_SIZE_BYTES", nullable = false)
	private long myResSizeBytes;

	public long getResSizeBytes() {
		return myResSizeBytes;
	}

	public void setResSizeBytes(long theResSizeBytes) {
		myResSizeBytes = theResSizeBytes;
	}

	public String getCanonicalVersion() {
		return myCanonicalVersion;
	}

	public void setCanonicalVersion(String theCanonicalVersion) {
		myCanonicalVersion = theCanonicalVersion;
	}

	public ResourceTable getResourceBinary() {
		return myResourceBinary;
	}

	public void setResourceBinary(ResourceTable theResourceBinary) {
		myResourceBinary = theResourceBinary;
	}

	public String getFhirVersionId() {
		return myFhirVersionId;
	}

	public void setFhirVersionId(String theFhirVersionId) {
		myFhirVersionId = theFhirVersionId;
	}

	public FhirVersionEnum getFhirVersionName() {
		return myFhirVersionName;
	}

	public void setFhirVersionName(FhirVersionEnum theFhirVersionName) {
		myFhirVersionName = theFhirVersionName;
	}

	public void setPackageVersion(NpmPackageVersionEntity thePackageVersion) {
		myPackageVersion = thePackageVersion;
	}

	public String getDirectory() {
		return myDirectory;
	}

	public void setDirectory(String theDirectory) {
		myDirectory = theDirectory;
	}

	public String getFilename() {
		return myFilename;
	}

	public void setFilename(String theFilename) {
		myFilename = theFilename;
	}

	public String getResourceType() {
		return myResourceType;
	}

	public void setResourceType(String theResourceType) {
		myResourceType = theResourceType;
	}

	public String getCanonicalUrl() {
		return myCanonicalUrl;
	}

	public void setCanonicalUrl(String theCanonicalUrl) {
		myCanonicalUrl = theCanonicalUrl;
	}

}