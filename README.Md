# Banka Kredi Sistemi

## Proje Açıklaması
Bu proje, bir bankanın kredi sistemini yöneten Spring Boot tabanlı bir REST API uygulamasıdır. Sistem, bireysel ve kurumsal müşterilerin kredi başvurularını, onay süreçlerini ve kredi yönetimini sağlar.

## Teknolojiler
- Java 17
- Spring Boot 3.2.3
- PostgreSQL
- Maven
- MapStruct
- Lombok
- Swagger/OpenAPI
- JWT (JSON Web Token) Authentication
- Spring Security

## Proje Yapısı
Proje, modüler bir yapıda tasarlanmış olup aşağıdaki modüllerden oluşmaktadır:

### 1. credit-core
- Temel utility sınıfları
- Ortak exception'lar
- Result yapıları
- JWT konfigürasyonu
- Security yapılandırması

### 2. credit-entities
- JPA entity sınıfları
- Abstract ve concrete entity'ler
- Müşteri tipleri (Bireysel ve Kurumsal)
- Kredi başvuru entity'leri
- Kredi tipleri ve durumları

### 3. credit-repositories
- JPA repository interfaces
- Custom repository metodları
- PostgreSQL entegrasyonu
- Kredi başvuru sorguları

### 4. credit-business
- İş mantığı katmanı
- DTO (Data Transfer Objects)
- Mapping işlemleri (MapStruct)
- Validation kuralları
- Kredi hesaplama servisleri
- Onay süreçleri

### 5. credit-webapi
- REST controller'lar
- Swagger/OpenAPI entegrasyonu
- Exception handling
- API endpoint'leri
- Security endpoints

## Mimari Yapı

### Katmanlı Mimari
1. **Web Katmanı** (credit-webapi)
   - HTTP isteklerini karşılar
   - Request/Response dönüşümlerini yapar
   - API endpoint'lerini sunar

2. **İş Mantığı Katmanı** (credit-business)
   - İş kurallarını uygular
   - Veri dönüşümlerini yapar
   - Validasyonları gerçekleştirir

3. **Veri Erişim Katmanı** (credit-repositories)
   - Veritabanı işlemlerini yönetir
   - Entity'ler üzerinde CRUD operasyonları gerçekleştirir

4. **Entity Katmanı** (credit-entities)
   - Veritabanı tablolarını temsil eder
   - İlişkileri tanımlar
   - Veri modelini oluşturur

5. **Çekirdek Katman** (credit-core)
   - Ortak bileşenleri içerir
   - Güvenlik yapılandırmasını sağlar
   - Utility sınıflarını barındırır

## Özellikler
- Bireysel ve kurumsal müşteri yönetimi
- Müşteri bilgilerinin validasyonu
- JWT tabanlı kimlik doğrulama ve yetkilendirme
- Kredi başvuru süreçleri
- Kredi onay/red mekanizması
- Kredi hesaplama servisleri
- REST API endpoints
- Swagger ile API dokümantasyonu
- PostgreSQL veritabanı entegrasyonu

## Kredi Süreçleri
### 1. Kredi Başvuru Süreci
- Müşteri bilgilerinin doğrulanması
- Kredi limiti hesaplama
- Risk analizi
- Başvuru formu validasyonu

### 2. Kredi Onay Süreci
- Başvuru değerlendirme
- Risk skorlaması
- Onay/red kararı
- Onay limiti belirleme

### 3. Kredi Hesaplama
- Aylık taksit hesaplama
- Toplam geri ödeme hesaplama
- Faiz oranı hesaplama
- Vade seçenekleri

### 4. Kredi Takip
- Kredi durumu izleme
- Ödeme takibi
- Vade uzatma talepleri
- Erken ödeme seçenekleri

## Güvenlik
- JWT tabanlı kimlik doğrulama
- Role-based yetkilendirme (RBAC)
- API endpoint güvenliği
- Şifreleme ve hash işlemleri
- Session yönetimi

## Kurulum
1. PostgreSQL veritabanını kurun ve `creditdb` adında bir veritabanı oluşturun
2. Projeyi klonlayın:
```bash
git clone https://github.com/kadirn7/BankApp-withJava.git
```
3. Proje dizinine gidin:
```bash
cd BankApp-withJava
```
4. Maven ile projeyi derleyin:
```bash
mvn clean install
```
5. Uygulamayı başlatın:
```bash
mvn spring-boot:run -pl credit-webapi
```

## API Dokümantasyonu
Swagger UI: `http://localhost:8080/swagger-ui/index.html`
OpenAPI JSON: `http://localhost:8080/v3/api-docs`

## Katkıda Bulunma
1. Bu repository'yi fork edin
2. Feature branch'i oluşturun (`git checkout -b feature/amazing-feature`)
3. Değişikliklerinizi commit edin (`git commit -m 'feat: Add some amazing feature'`)
4. Branch'inizi push edin (`git push origin feature/amazing-feature`)
5. Pull Request oluşturun

