package org.example.topilma.config;

import lombok.RequiredArgsConstructor;
import org.example.topilma.entity.*;
import org.example.topilma.repository.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {

  final UserRepo userRepo;
  final PasswordEncoder passwordEncoder;
  final RoleRepo roleRepo;
  final DistrictRepo districtRepo;
  final RegionRepo regionRepo;
  final MarketRepo marketRepo;
  final ItemRepo itemRepo;

  @Override
  public void run(String... args) throws Exception {
    List<Role> all = roleRepo.findAll();
    if (all.isEmpty()) {
      roleRepo.saveAll(List.of(
              new Role("ROLE_ADMIN"),
              new Role("ROLE_SUPER_ADMIN"),
              new Role("ROLE_OPERATOR"),
              new Role("ROLE_USER")
      ));
      List<Role> adminRoles = roleRepo.findAdminRoles();
      User user = User.builder().username("superadmin").firstName("aziz")
              .password(passwordEncoder.encode("123")).isEnabled(true)
              .roles(adminRoles).build();
      userRepo.save(user);

      List<District> andijon = districtRepo.saveAll(List.of(
              new District("Andijon"),
              new District("Andijon tumani"),
              new District("Asaka tumani"),
              new District("Baliqchi tumani"),
              new District("Bo'z tumani"),
              new District("Buloqboshi tumani"),
              new District("Izboskan tumani"),
              new District("Jalaquduq tumani"),
              new District("Marxamat tumani"),
              new District("Oltinko'l tumani"),
              new District("Paxtaobod tumani"),
              new District("Paxtaobod tumani"),
              new District("Qo'rg'ontepa tumani"),
              new District("Shaxrixon tumani"),
              new District("Ulug'nor tumani"),
              new District("Xo'jaobod tumani"),
              new District("Xunobod tumani")
      ));
      List<District> buxoro = districtRepo.saveAll(List.of(
              new District("Buxoro"),
              new District("Buxoro tumani"),
              new District("G'ijduvon tumani"),
              new District("Jondor tumani"),
              new District("Kogon tumani"),
              new District("Kogon"),
              new District("Olot tumani"),
              new District("Peshku tumani"),
              new District("Qorako'l tumani"),
              new District("Qorovulbozor tumani"),
              new District("Romitan tumani"),
              new District("Shofirkon tumani"),
              new District("Vobkent tumani")
      ));
      List<District> jizzax = districtRepo.saveAll(List.of(
              new District("Jizzax"),
              new District("Jizzax viloyati"),
              new District("Arnasoy tumani"),
              new District("Baxmal tumani"),
              new District("Do'stlik tumani"),
              new District("Forish tumani"),
              new District("G'allaorol tumani"),
              new District("Mirzacho'l tumani"),
              new District("Paxtakor tumani"),
              new District("Sh.Rashidov tumani"),
              new District("Sh.Rashidov tumani"),
              new District("Yangiobod tumani"),
              new District("Zarbdor tumani"),
              new District("Zomin tumani")
      ));
      List<District> qashqadaryo = districtRepo.saveAll(List.of(
              new District("Qarshi"),
              new District("Qarshi tumani"),
              new District("Chiroqchi tumani"),
              new District("Dehqonobod tumani"),
              new District("G'uzor tumani"),
              new District("Kasbi tumani"),
              new District("Kitob tumani"),
              new District("Koson tumani"),
              new District("Mirishkor tumani"),
              new District("Muborak tumani"),
              new District("Shahrisabz tumani"),
              new District("Yakkabog' tumani")
      ));
      List<District> qoraqalpogiston = districtRepo.saveAll(List.of(
              new District("Nukus"),
              new District("Amudaryo tumani"),
              new District("Beruniy tumani"),
              new District("Chimboy tumani"),
              new District("Ellikqala tumani"),
              new District("Kegeyli tumani"),
              new District("Mo'ynoq tumani"),
              new District("Qonliko'l tumani"),
              new District("Qorao'zak tumani"),
              new District("Shumanay tumani"),
              new District("Taxtako'pir tumani"),
              new District("To'rtko'l tumani"),
              new District("Xo'jayli tumani")
      ));

      List<District> namangan = districtRepo.saveAll(List.of(
              new District("Namangan"),
              new District("Chortoq tumani"),
              new District("Chust tumani"),
              new District("Kosonsoy tumani"),
              new District("Mingbuloq tumani"),
              new District("Norin tumani"),
              new District("Pop tumani"),
              new District("To'raqo'rg'on tumani"),
              new District("Uychi tumani"),
              new District("Yangiqo'rg'on tumani")
      ));

      List<District> navoi = districtRepo.saveAll(List.of(
              new District("Navoiy"),
              new District("Konimex tumani"),
              new District("Karmana tumani"),
              new District("Nurota tumani"),
              new District("Qiziltepa tumani"),
              new District("Tomdi tumani"),
              new District("Uchquduq tumani"),
              new District("Zarafshon")
      ));
      List<District> samarqand = districtRepo.saveAll(List.of(
              new District("Samarqand"),
              new District("Bulung'ur tumani"),
              new District("Ishtixon tumani"),
              new District("Jomboy tumani"),
              new District("Kattaqo'rg'on tumani"),
              new District("Narpay tumani"),
              new District("Oqdaryo tumani"),
              new District("Paxtachi tumani"),
              new District("Payariq tumani"),
              new District("Qo'shrabot tumani"),
              new District("Toyloq tumani"),
              new District("Urgut tumani")
      ));
      List<District> surxondaryo = districtRepo.saveAll(List.of(
              new District("Termiz"),
              new District("Angor tumani"),
              new District("Boysun tumani"),
              new District("Denov tumani"),
              new District("Jarqo'rg'on tumani"),
              new District("Muzrabot tumani"),
              new District("Oltinsoy tumani"),
              new District("Qiziriq tumani"),
              new District("Sariosiyo tumani"),
              new District("Sherobod tumani"),
              new District("Sho'rchi tumani"),
              new District("Uzun tumani")
      ));
      List<District> sirdaryo = districtRepo.saveAll(List.of(
              new District("Guliston"),
              new District("Boyovut tumani"),
              new District("Mirzaobod tumani"),
              new District("Oqoltin tumani"),
              new District("Sardoba tumani"),
              new District("Sayxunobod tumani"),
              new District("Xovos tumani")
      ));
      List<District> toshkent = districtRepo.saveAll(List.of(
              new District("Toshkent"),
              new District("Bekobod tumani"),
              new District("Bo'stonliq tumani"),
              new District("Chinoz tumani"),
              new District("Qibray tumani"),
              new District("Ohangaron tumani"),
              new District("Oqqo'rg'on tumani"),
              new District("Parkent tumani"),
              new District("Piskent tumani"),
              new District("Quyichirchiq tumani"),
              new District("Yuqorichirchiq tumani"),
              new District("Yangiyo'l tumani"),
              new District("Zangiota tumani")
      ));
      List<District> fargona = districtRepo.saveAll(List.of(
              new District("Farg'ona"),
              new District("Bag'dod tumani"),
              new District("Beshariq tumani"),
              new District("Buvayda tumani"),
              new District("Dang'ara tumani"),
              new District("Furqat tumani"),
              new District("Marg'ilon"),
              new District("Oltiariq tumani"),
              new District("Qo'qon"),
              new District("Quvasoy"),
              new District("Rishton tumani"),
              new District("So'x tumani"),
              new District("Toshloq tumani"),
              new District("Uchko'prik tumani"),
              new District("Yozyovon tumani")
      ));
      regionRepo.save(Region.builder().name("Surxondaryo viloyati").district(surxondaryo).build());
      regionRepo.save(Region.builder().name("Samarqand viloyati").district(samarqand).build());
      regionRepo.save(Region.builder().name("Navoiy viloyati").district(navoi).build());
      regionRepo.save(Region.builder().name("Andijon viloyati").district(andijon).build());
      regionRepo.save(Region.builder().name("Buxoro viloyati").district(buxoro).build());
      regionRepo.save(Region.builder().name("Jizzax viloyati").district(jizzax).build());
      regionRepo.save(Region.builder().name("Qashqadaryo viloyati").district(qashqadaryo).build());
      regionRepo.save(Region.builder().name("Qoraqalpog'iston Respublikasi").district(qoraqalpogiston).build());
      regionRepo.save(Region.builder().name("Namangan viloyati").district(namangan).build());
      regionRepo.save(Region.builder().name("Sirdaryo viloyati").district(sirdaryo).build());
      regionRepo.save(Region.builder().name("Toshkent viloyati").district(toshkent).build());
      regionRepo.save(Region.builder().name("Farg'ona viloyati").district(fargona).build());

      marketRepo.saveAll(List.of(
              new Market("Biopasport"),
              new Market("Identifikatsiya ID kartasi"),
              new Market("haydovchilik guvohnomasi"),
              new Market("Avtotransport guvohnomasi(tex.passport) "),
              new Market("Davlat ro'yxatidan o'tkazilganligi to'g'risidagi guvohnoma"),
              new Market("Xizmat guvohnomasi"),
              new Market("Kadastr hujjatlari"),
              new Market("Rasmiy hujjatlar"),
              new Market("Guvohnoma"),
              new Market("Hujjatlar")
      ));

      itemRepo.saveAll(List.of(
              new Item("Telefon/smartfon"),
              new Item("Planshet"),
              new Item("Kompyuter/notebook"),
              new Item("Aksesuar"),
              new Item("Plastik karta"),
              new Item("Musiqa asbobi"),
              new Item("Sport anjomi"),
              new Item("Kalit"),
              new Item("Boshqa ashyo")
      ));


    }


  }
}
